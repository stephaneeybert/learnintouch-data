package com.thalasoft.learnintouch.data.jpa.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;

import com.thalasoft.learnintouch.data.jpa.domain.AbstractEntity;
import com.thalasoft.learnintouch.data.jpa.domain.NewsStory;

public class NewsStoryAssert extends AbstractAssert<NewsStoryAssert, NewsStory> {

	private NewsStoryAssert(NewsStory actual) {
		super(actual, NewsStoryAssert.class);
	}
	
	public static NewsStoryAssert assertThatNewsStory(NewsStory actual) {
		return new NewsStoryAssert(actual);
	}

	public NewsStoryAssert hasId(Long id) {
		isNotNull();
		assertThat(actual.getId()).overridingErrorMessage("Expected the id to be <%s> but was <%s>.", id, actual.getId()).isEqualTo(id);
		return this;
	}

	public NewsStoryAssert hasAnIdNotNull() {
		isNotNull();
		assertThat(actual.getId()).overridingErrorMessage("Expected the id to be not null but was null.").isNotNull();
		return this;
	}

	public NewsStoryAssert isSameAs(AbstractEntity entity) {
		isNotNull();
		assertThat(actual.hashCode()).overridingErrorMessage("Expected the hash code to be <%s> but was <%s>.", entity.hashCode(), actual.hashCode()).isEqualTo(entity.hashCode());
		return this;
	}
	
	public NewsStoryAssert exists() {
		assertThat(actual).overridingErrorMessage("Expected the news story to exist but it didn't.").isNotNull();
		return this;
	}
	
	public NewsStoryAssert doesNotExist() {
		isNull();
		assertThat(actual).overridingErrorMessage("Expected the news story not to exist but it did.").isNull();
		return this;
	}
	
}
