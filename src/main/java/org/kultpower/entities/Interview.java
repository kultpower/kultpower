package org.kultpower.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sebastian on 21.02.16.
 */
@Entity
@Table(name = "interview")
@NamedEntityGraph(name = "Interview.texte",
		attributeNodes = @NamedAttributeNode("texte"))
public class Interview {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private String id = null;

	@Column(name="title")
	private String title;

	@Column
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate datum;

	@OneToMany(mappedBy = "interview", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("position ASC")
	private Set<InterviewText> texte = new TreeSet<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public Set<InterviewText> getTexte() {
		return texte;
	}

	public void setTexte(Set<InterviewText> texte) {
		this.texte = texte;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}


	public String getIntroText() {
		StringBuffer ret = new StringBuffer();
		int count=0;
		Iterator<InterviewText> iterator = getTexte().iterator();
		while (iterator.hasNext() && count < 2) {
			InterviewText text = iterator.next();
			ret.append(text.getPrefix() + ": " + text.getText() + "\n");
			count++;
		}
		return ret.toString();
	}
}
