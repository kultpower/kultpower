package org.kultpower.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sebastian on 28.01.16.
 */
@Entity
@Table(name = "zeitschrift")
@NamedEntityGraph(name = "Zeitschrift.ausgaben",
		attributeNodes = @NamedAttributeNode("ausgaben"))
public class Zeitschrift {

	@Column
	@javax.persistence.Id
	private String id;

	@Column
	private String name;


	@OneToMany(mappedBy = "zeitschrift", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("shortname ASC")
	private Set<Ausgabe> ausgaben = new TreeSet<>();

	public Set<Ausgabe> getAusgaben() {
		return ausgaben;
	}

	public void setAusgaben(Set<Ausgabe> ausgaben) {
		this.ausgaben = ausgaben;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String ret = "";
		ret += ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
		ret += "\n";
		int i = 0;
		for (Ausgabe g : getAusgaben()) {
			ret += g.toString() + "\n";
			i++;
			if (i>10) {
				break;
			}
		}
		return ret;
	}
}
