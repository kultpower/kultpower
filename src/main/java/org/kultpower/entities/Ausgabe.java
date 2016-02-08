package org.kultpower.entities;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Year;

/**
 * Created by sebastian on 28.01.16.
 */
@Entity
@Table(name = "ausgabe")
public class Ausgabe
//		implements Comparable<Ausgabe>
{


	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",
			strategy = "uuid")
	@Column(name = "id", updatable = false, nullable = false)
	private String id = null;

	@Column
	private LocalDate erscheinungsdatum;

	@Column
	private Integer jahr;

	@Column
	private Integer nummer;

	@Column
	private String shortname;

	@Column
	private String name;

	@Column
	private String coverfile;

	@ManyToOne
	@JoinColumn(name = "zeitschrift")
	private Zeitschrift zeitschrift;

	public Zeitschrift getZeitschrift() {
		return zeitschrift;
	}

	public void setZeitschrift(Zeitschrift zeitschrift) {
		this.zeitschrift = zeitschrift;
	}

	public LocalDate getErscheinungsdatum() {
		return erscheinungsdatum;
	}

	public void setErscheinungsdatum(LocalDate erscheinungsdatum) {
		this.erscheinungsdatum = erscheinungsdatum;
	}


	public Integer getJahr() {
		return jahr;
	}

	public void setJahr(Integer jahr) {
		this.jahr = jahr;
	}

	public String getCoverfile() {
		return coverfile;
	}

	public void setCoverfile(String coverFile) {
		this.coverfile = coverFile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Integer getNummer() {
		return nummer;
	}

	public void setNummer(Integer nummer) {
		this.nummer = nummer;
	}

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).setExcludeFieldNames("zeitschrift").toString();
		//return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
