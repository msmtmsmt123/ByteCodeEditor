package net.niko.classld;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VirtualFile
{

    private String name;
    private byte[] data;
}
