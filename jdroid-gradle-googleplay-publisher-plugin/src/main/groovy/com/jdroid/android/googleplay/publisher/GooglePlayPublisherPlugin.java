package com.jdroid.android.googleplay.publisher;

import com.jdroid.android.googleplay.publisher.task.CleanTrackTask;
import com.jdroid.android.googleplay.publisher.task.IncreaseStagedRolloutTask;
import com.jdroid.android.googleplay.publisher.task.ListApksTask;
import com.jdroid.android.googleplay.publisher.task.ListTracksTask;
import com.jdroid.android.googleplay.publisher.task.MetadataVerificationTask;
import com.jdroid.android.googleplay.publisher.task.PromoteFromAlphaToBetaTask;
import com.jdroid.android.googleplay.publisher.task.PromoteFromAlphaToRolloutTask;
import com.jdroid.android.googleplay.publisher.task.PromoteFromBetaToRolloutTask;
import com.jdroid.android.googleplay.publisher.task.PromoteFromRolloutToProductionTask;
import com.jdroid.android.googleplay.publisher.task.PublishApkTask;
import com.jdroid.android.googleplay.publisher.task.PublishMetadataTask;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GooglePlayPublisherPlugin implements Plugin<Project> {
	
	@Override
	public void apply(Project project) {

		project.getTasks().create("googlePlayVerifyMetadata", MetadataVerificationTask.class);
		project.getTasks().create("googlePlayPublishMetadata", PublishMetadataTask.class);
		project.getTasks().create("googlePlayListAPKs", ListApksTask.class);
		project.getTasks().create("googlePlayPublishAPK", PublishApkTask.class);
		project.getTasks().create("googlePlayPromoteFromAlphaToBeta", PromoteFromAlphaToBetaTask.class);
		project.getTasks().create("googlePlayPromoteFromAlphaToRollout", PromoteFromAlphaToRolloutTask.class);
		project.getTasks().create("googlePlayPromoteFromBetaToRollout", PromoteFromBetaToRolloutTask.class);
		project.getTasks().create("googlePlayIncreaseStagedRollout", IncreaseStagedRolloutTask.class);
		project.getTasks().create("googlePlayPromoteFromRolloutToProduction", PromoteFromRolloutToProductionTask.class);
		project.getTasks().create("googlePlayListTracks", ListTracksTask.class);
		project.getTasks().create("googlePlayCleanTrack", CleanTrackTask.class);
	}

}