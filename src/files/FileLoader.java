package files;

import java.io.File;

public class FileLoader implements AssetLoader{
	private AssetLoader assetLoader;
	public FileLoader(AssetLoader assetLoader) {
		this.assetLoader=assetLoader;
	}
	public void loadFile(File file)
	{
		assetLoader.loadFile(file);
	}
	public void saveFile(File file)
	{
		assetLoader.saveFile(file);
	}
}
