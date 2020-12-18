package com.jagsaund.rxuploader;

import androidx.annotation.NonNull;
import com.jagsaund.rxuploader.job.Job;
import com.jagsaund.rxuploader.job.Status;

import io.reactivex.rxjava3.core.Observable;

public interface UploadInteractor {
    @NonNull
    Observable<Job> get(@NonNull String id);

    @NonNull
    Observable<Job> getAll();

    @NonNull
    Observable<Job> save(@NonNull Job job);

    @NonNull
    Observable<Job> update(@NonNull Status status);

    @NonNull
    Observable<Job> delete(@NonNull String id);

    @NonNull
    Observable<Status> upload(@NonNull String id);
}