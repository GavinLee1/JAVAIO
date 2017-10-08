package com.lgz.service.channel;

import com.lgz.service.stream.DataSource;
import com.lgz.service.stream.Util;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by GAVIN on 2017/10/8.
 */
public class BenchMark {
    private static File sourceFile = new File(DataSource.IMAGE);

    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.print(name + " : ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public abstract void test() throws IOException;
    }

    private static Tester[] testCases = {
            new Tester("Stream Read Write") {
                @Override
                public void test() throws IOException {
                    File desFile = new File(Util.getFolder() + "stream-" + sourceFile.getName());
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(desFile));
                    BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile));

                    byte[] buffer = new byte[1024 * 10];
                    int bytesRead = 0;

                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer);
                    }
                    in.close();
                    out.close();
                }
            },

            new Tester("Random Read Write") {
                @Override
                public void test() throws IOException {
                    File desFile = new File(Util.getFolder() + "random-" + sourceFile.getName());

                    RandomAccessFile in = new RandomAccessFile(sourceFile, "r");
                    RandomAccessFile out = new RandomAccessFile(desFile, "rw");

                    byte[] buffer = new byte[1024 * 10];
                    int bytesRead = 0;

                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer);
                    }
                    in.close();
                    out.close();
                }
            },

            new Tester("Channel File Read Write") {
                @Override
                public void test() throws IOException {
                    File desFile = new File(Util.getFolder() + "channelfile-" + sourceFile.getName());

                    FileChannel in = new FileInputStream(sourceFile).getChannel();
                    FileChannel out = new FileOutputStream(desFile).getChannel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);

                    while (in.read(buffer) != -1) {
                        buffer.flip();
                        out.write(buffer);
                        buffer.clear();
                    }

                    in.close();
                    out.close();
                }
            },

            new Tester("Channel Random Read Write") {
                @Override
                public void test() throws IOException {
                    File desFile = new File(Util.getFolder() + "channelrandom-" + sourceFile.getName());

                    FileChannel in = new RandomAccessFile(sourceFile, "r").getChannel();
                    FileChannel out = new RandomAccessFile(desFile, "rw").getChannel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);

                    while (in.read(buffer) != -1) {
                        buffer.flip();
                        out.write(buffer);
                        buffer.clear();
                    }

                    in.close();
                    out.close();
                }
            },

            new Tester("Mapped Random Read Write") {
                @Override
                public void test() throws IOException {
                    File desFile = new File(Util.getFolder() + "mappedchannel-" + sourceFile.getName());

                    long length = sourceFile.length();
                    MappedByteBuffer in = new RandomAccessFile(sourceFile, "r").getChannel()
                            .map(FileChannel.MapMode.READ_ONLY, 0, length);

                    MappedByteBuffer out = new RandomAccessFile(desFile, "rw").getChannel()
                            .map(FileChannel.MapMode.READ_WRITE, 0, length);

                    while (in.hasRemaining()) {
                        out.put(in.get());
                    }
                }
            }
    };

    public static void main(String[] args) {
        for (Tester test : testCases) {
            test.runTest();
        }
    }

}
