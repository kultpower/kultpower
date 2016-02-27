package org.kultpower;

/**
 * Created by sebastian on 27.02.16.
 */
public class Disqus {

	public Disqus() {

	}

	public Disqus(String url, String identifier, String title) {
		this.url = url;
		this.identifier = identifier;
		this.title=title;
	}

	private String url;

	private String identifier;

	private String title;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
