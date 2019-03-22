package p01_FileStream;

public class Progress {
    private final FileEntity fileEntity;

    public Progress(FileEntity fileEntity)
    {
        this.fileEntity = fileEntity;
    }

    public int getCurrentPercent()
    {
        return this.fileEntity.getSent() * 100 / this.fileEntity.getLength();
    }
}
