package org.kultpower.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

/**
 * Created by sebastian on 21.02.16.
 */
@Entity(name="interviewtext")
@Table(name="interviewtext")
public class InterviewText {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",
			strategy = "uuid")
	@Column(name = "id", updatable = false, nullable = false)
	private String id = null;

	@Column
	private Integer position;

	@Column
	private String text;

	@Column
	private String prefix;

	@ManyToOne
	@JoinColumn(name = "interview")
	private Interview interview;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
