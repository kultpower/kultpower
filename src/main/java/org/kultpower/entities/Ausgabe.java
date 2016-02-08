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
	private Number nummmer;

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

	public Number getNummmer() {
		return nummmer;
	}

	public void setNummmer(Number nummmer) {
		this.nummmer = nummmer;
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

//	public String getShortname() {
//		return shortname;
//	}
//
//	public void setShortname(String shortname) {
//		this.shortname = shortname;
//	}
//
//
//	@Override
//	public int compareTo(Ausgabe o) {
//		return this.shortname.compareTo(o.getShortname());
//	}
//
//	@Override
//	public boolean equals(Object a) {
//		if (!(a instanceof Ausgabe)) {
//			return false;
//		}
//		return this.shortname.equals(((Ausgabe) a).getShortname());
//	}

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
