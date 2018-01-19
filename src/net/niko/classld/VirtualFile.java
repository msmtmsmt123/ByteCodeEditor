package net.niko.classld;

public class VirtualFile
{

    private String name;
    private byte[] data;

    public VirtualFile(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public byte[] getData() {
        return data;
    }
}
