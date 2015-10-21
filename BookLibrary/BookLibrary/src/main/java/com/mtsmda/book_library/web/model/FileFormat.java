package com.mtsmda.book_library.web.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "file_formats")
public class FileFormat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_format_id", nullable = false, unique = true)
	private Integer fileFormatId;
	
	@Column(name = "file_format", nullable = false, unique = true)
	private String fileFormat;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fileFormat")
	private Set<Book> books = new HashSet<>();

	public FileFormat() {

	}

	public FileFormat(String fileFormat) {
		setFileFormat(fileFormat);
	}

	public Integer getFileFormatId() {
		return fileFormatId;
	}

	public void setFileFormatId(Integer fileFormatId) {
		this.fileFormatId = fileFormatId;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((fileFormat == null) ? 0 : fileFormat.hashCode());
		result = prime * result + ((fileFormatId == null) ? 0 : fileFormatId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileFormat other = (FileFormat) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (fileFormat == null) {
			if (other.fileFormat != null)
				return false;
		} else if (!fileFormat.equals(other.fileFormat))
			return false;
		if (fileFormatId == null) {
			if (other.fileFormatId != null)
				return false;
		} else if (!fileFormatId.equals(other.fileFormatId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileFormat [fileFormatId=" + fileFormatId + ", fileFormat=" + fileFormat + ", books=" + books + "]";
	}

}