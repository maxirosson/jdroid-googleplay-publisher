package com.jdroid.android.googleplay.publisher;

import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.util.Lists;
import com.jdroid.java.exception.UnexpectedException;
import com.jdroid.java.utils.StringUtils;

import java.util.List;
import java.util.Locale;

public class App {

	private AppContext appContext;
	private List<LocaleListing> localeListings;
	private LocaleListing defaultLocaleListing;

	public App(AppContext appContext) {
		this.appContext = appContext;
		
		this.localeListings = Lists.newArrayList();
		for (String each : StringUtils.splitToCollectionWithCommaSeparator(appContext.getLocales())) {
			String[] split = each.split("-");
			String language = split[0];
			String country = "";
			if (split.length > 1) {
				country = split[1];
			}
			localeListings.add(new LocaleListing(new Locale(language, country), appContext.getMetadataPath()));
		}
		this.defaultLocaleListing = new LocaleListing(null, appContext.getMetadataPath());
	}

	public String getTitle(LocaleListing localeListing) {
		String title = localeListing.getTitle();
		if (title == null) {
			title = defaultLocaleListing.getTitle();
		}
		if (title == null) {
			throw new UnexpectedException("The title.txt was not found for locale " + localeListing.getLanguageTag());
		}
		return title;
	}

	public String getFullDescription(LocaleListing localeListing) {
		String fullDescription = localeListing.getFullDescription();
		if (fullDescription == null) {
			fullDescription = defaultLocaleListing.getFullDescription();
		}
		if (fullDescription == null) {
			throw new UnexpectedException("The full_description.txt was not found for locale " + localeListing.getLanguageTag());
		}
		return fullDescription;
	}

	public String getShortDescription(LocaleListing localeListing) {
		String shortDescription = localeListing.getShortDescription();
		if (shortDescription == null) {
			shortDescription = defaultLocaleListing.getShortDescription();
		}
		if (shortDescription == null) {
			throw new UnexpectedException("The short_description.txt was not found for locale " + localeListing.getLanguageTag());
		}
		return shortDescription;
	}
	
	public String getVideo(LocaleListing localeListing) {
		String video = localeListing.getVideo();
		if (video == null) {
			video = defaultLocaleListing.getVideo();
		}
		if (video == null && appContext.isVideoRequired()) {
			throw new UnexpectedException("The video.txt was not found for locale " + localeListing.getLanguageTag());
		}
		return video;
	}

	public AbstractInputStreamContent getFeatureGraphic(LocaleListing localeListing) {
		AbstractInputStreamContent featureGraphic = localeListing.getFeatureGraphic();
		if (featureGraphic == null) {
			featureGraphic = defaultLocaleListing.getFeatureGraphic();
		}
		if (featureGraphic == null) {
			throw new UnexpectedException("images/featureGraphic.png was not found for locale " + localeListing.getLanguageTag());
		}
		return featureGraphic;
	}

	public AbstractInputStreamContent getPromoGraphic(LocaleListing localeListing) {
		AbstractInputStreamContent promoGraphic = localeListing.getPromoGraphic();
		if (promoGraphic == null) {
			promoGraphic = defaultLocaleListing.getPromoGraphic();
		}
		if (promoGraphic == null && appContext.isPromoGraphicRequired()) {
			throw new UnexpectedException("images/promoGraphic.png was not found for locale " + localeListing.getLanguageTag());
		}
		return promoGraphic;
	}

	public AbstractInputStreamContent getHighResolutionIcon(LocaleListing localeListing) {
		AbstractInputStreamContent highResolutionIcon = localeListing.getHighResolutionIcon();
		if (highResolutionIcon == null) {
			highResolutionIcon = defaultLocaleListing.getHighResolutionIcon();
		}
		if (highResolutionIcon == null) {
			throw new UnexpectedException("images/icon.png was not found for locale " + localeListing.getLanguageTag());
		}
		return highResolutionIcon;
	}

	public AbstractInputStreamContent getTvBanner(LocaleListing localeListing) {
		AbstractInputStreamContent tvBanner = localeListing.getTvBanner();
		if (tvBanner == null) {
			tvBanner = defaultLocaleListing.getTvBanner();
		}
		if (tvBanner == null && appContext.isTvBannerRequired()) {
			throw new UnexpectedException("images/tvBanner.png was not found for locale " + localeListing.getLanguageTag());
		}
		return tvBanner;
	}

	public List<AbstractInputStreamContent> getPhoneScreenshots(LocaleListing localeListing) {
		List<AbstractInputStreamContent> phoneScreenshots = localeListing.getPhoneScreenshots();
		if (phoneScreenshots.isEmpty()) {
			phoneScreenshots = defaultLocaleListing.getPhoneScreenshots();
		}
		if (phoneScreenshots.isEmpty() && appContext.isPhoneScreenshotsRequired()) {
			throw new UnexpectedException("Phone screenshots were not found for locale " + localeListing.getLanguageTag());
		}
		return phoneScreenshots;
	}

	public List<AbstractInputStreamContent> getSevenInchScreenshots(LocaleListing localeListing) {
		List<AbstractInputStreamContent> sevenInchScreenshots = localeListing.getSevenInchScreenshots();
		if (sevenInchScreenshots.isEmpty()) {
			sevenInchScreenshots = defaultLocaleListing.getSevenInchScreenshots();
		}
		if (sevenInchScreenshots.isEmpty() && appContext.isSevenInchScreenshotsRequired()) {
			throw new UnexpectedException("7 Inch screenshots were not found for locale " + localeListing.getLanguageTag());
		}
		return sevenInchScreenshots;
	}

	public List<AbstractInputStreamContent> getTenInchScreenshots(LocaleListing localeListing) {
		List<AbstractInputStreamContent> tenInchScreenshots = localeListing.getTenInchScreenshots();
		if (tenInchScreenshots.isEmpty()) {
			tenInchScreenshots = defaultLocaleListing.getTenInchScreenshots();
		}
		if (tenInchScreenshots.isEmpty() && appContext.isTenInchScreenshotsRequired()) {
			throw new UnexpectedException("10 Inch screenshots were not found for locale " + localeListing.getLanguageTag());
		}
		return tenInchScreenshots;
	}
	
	public List<AbstractInputStreamContent> getWearScreenshots(LocaleListing localeListing) {
		List<AbstractInputStreamContent> wearScreenshots = localeListing.getWearScreenshots();
		if (wearScreenshots.isEmpty()) {
			wearScreenshots = defaultLocaleListing.getWearScreenshots();
		}
		if (wearScreenshots.isEmpty() && appContext.isWearScreenshotsRequired()) {
			throw new UnexpectedException("Wear screenshots were not found for locale " + localeListing.getLanguageTag());
		}
		return wearScreenshots;
	}
	
	public List<AbstractInputStreamContent> getTvScreenshots(LocaleListing localeListing) {
		List<AbstractInputStreamContent> tvScreenshots = localeListing.getTvScreenshots();
		if (tvScreenshots.isEmpty()) {
			tvScreenshots = defaultLocaleListing.getTvScreenshots();
		}
		if (tvScreenshots.isEmpty() && appContext.isTvScreenshotsRequired()) {
			throw new UnexpectedException("Tv screenshots were not found for locale " + localeListing.getLanguageTag());
		}
		return tvScreenshots;
	}
	
	public String getChangelog(LocaleListing localeListing, Integer versionCode) {
		String changelog = localeListing.getChangelog(versionCode);
		if (changelog == null) {
			changelog = defaultLocaleListing.getChangelog(versionCode);
		}
		return changelog;
	}
	
	public List<LocaleListing> getLocaleListings() {
		return localeListings;
	}

	public LocaleListing getDefaultLocaleListing() {
		return defaultLocaleListing;
	}
	
	public String getApplicationId() {
		return appContext.getApplicationId();
	}

	public AppContext getAppContext() {
		return appContext;
	}
}