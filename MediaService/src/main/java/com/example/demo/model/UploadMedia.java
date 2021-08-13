package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UploadMedia {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int uid;
	private String title;
	private String description;
	private String tags;
	private String url;
	private String date;
	private String username;
	private int likes;
	


	public UploadMedia(int id, int uid, String title, String description, String tags, String url) {
		super();
		this.id = id;
		this.uid = uid;
		this.title = title;
		this.description = description;
		this.tags = tags;
		this.url = url;

	}

	public UploadMedia(int uid, String title, String description, String tags, String url, String date,
			String username, int likes) {
		super();
		this.uid = uid;
		this.title = title;
		this.description = description;
		this.tags = tags;
		this.url = url;
		this.username = username;
		this.likes=likes;
		this.setDate(date);

	}
	public UploadMedia() {}
}
