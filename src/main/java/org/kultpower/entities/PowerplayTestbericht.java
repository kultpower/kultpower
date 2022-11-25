package org.kultpower.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Created by sebastian on 11.01.16.
 */
@Entity
@Table(name = "powerplay_testberichte")
public class PowerplayTestbericht {

	@jakarta.persistence.Id
	@Column
	private Integer id;

	@Column
	private String name;

	@Column
	private int gesamt;

	@Column
	private int grafik;

	@Column
	private int sound;

	public int getGesamt() {
		return gesamt;
	}

	public void setGesamt(int gesamt) {
		this.gesamt = gesamt;
	}

	public int getGrafik() {
		return grafik;
	}

	public void setGrafik(int grafik) {
		this.grafik = grafik;
	}

	public int getSound() {
		return sound;
	}

	public void setSound(int sound) {
		this.sound = sound;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
