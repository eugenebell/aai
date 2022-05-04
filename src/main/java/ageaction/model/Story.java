package ageaction.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "story")
public class Story {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STORY_ID")
	private Long storyID;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "SUMMARY")
	private String summary;
	
	@Column(name = "STORY_CONTENT")
	private String storyContent;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "PUBLISHED")
	private Boolean publish;
	
	@Column(name = "IMAGE")
	private String image;
	
	@Column(name = "TIMG")
	private String timg;

	@Column(name = "LIKES")
	private Integer likes;
	
	@Column(name = "CONTENT_REPORT_FLAGGED")
	private Boolean contentReportFlagged;
	
	@Column(name = "VIDEO_URL")
	private String videoURL;
	
	@Column(name = "PODCAST_URL")
	private String podcastURL;

	@ManyToOne
	@JoinColumn(name="AUTHOR_ID")
	private Author author;
	
	@ManyToMany(mappedBy = "stories")
	private Set<Label> labels = new HashSet<Label>();;

	public Long getStoryID() {
		return storyID;
	}

	public void setStoryID(Long storyID) {
		this.storyID = storyID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getStoryContent() {
		return storyContent;
	}

	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getPublish() {
		return publish;
	}

	public void setPublish(Boolean publish) {
		this.publish = publish;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Boolean getContentReportFlagged() {
		return contentReportFlagged;
	}

	public void setContentReportFlagged(Boolean contentReportFlagged) {
		this.contentReportFlagged = contentReportFlagged;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public String getPodcastURL() {
		return podcastURL;
	}

	public void setPodcastURL(String podcastURL) {
		this.podcastURL = podcastURL;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTimg() {
		return timg;
	}

	public void setTimg(String timg) {
		this.timg = timg;
	}

}
