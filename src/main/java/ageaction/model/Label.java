package ageaction.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "label")
public class Label {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LABEL_ID")
	private Long labelID;
	
	@Column(name = "LABEL_NAME")
	private String labelName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "story_label_link", 
      joinColumns = @JoinColumn(name = "LABEL_ID"), 
      inverseJoinColumns = @JoinColumn(name = "STORY_ID"))
	private List<Story> stories;

	public Long getLabelID() {
		return labelID;
	}

	public void setLabelID(Long labelID) {
		this.labelID = labelID;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	
}
