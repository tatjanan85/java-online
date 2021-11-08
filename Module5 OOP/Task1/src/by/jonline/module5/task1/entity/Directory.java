package by.jonline.module5.task1.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory {

	private String name;
	private List<File> files = new ArrayList<File>();
	private List<Directory> directories = new ArrayList<Directory>();

	public  Directory() {
		name = "New Folder";
	}

	public Directory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean addDirectory(Directory directory) {
		if (directoryExist(directory.getName())) {
			return false;
		}

		directories.add(directory);
		return true;
	}

	private boolean directoryExist(String name) {
		for (Directory dir : directories) {
			if (dir.getName() == name) {
				return true;
			}
		}
		return false;
	}

	public boolean addFile(File file) {
		if (fileExist(file.getName())) {
			return false;
		}

		files.add(file);
		return true;
	}

	public boolean fileExist(String name) {
		for (File file : files) {
			if (file.getName() == name) {
				return true;
			}
		}
		return false;
	}

	public void deleteFile(File file) {
		for (File f : files) {
			if (f.getName() == file.getName()) {
				files.remove(file);
				break;
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Directory)) return false;
		Directory directory1 = (Directory) o;
		return Objects.equals(name, directory1.name) &&
				Objects.equals(directories, directory1.directories) &&
				Objects.equals(files, directory1.files);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, directories, files);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {" +
				"name='" + name + '\'' +
				", directories=" + directories +
				", files=" + files +
				'}';
	}
}
