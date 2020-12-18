package com.jagsaund.rxuploader.sample.model.data;

import androidx.annotation.NonNull;
import com.jagsaund.rxuploader.job.Status;

public interface DataModel {
    @DataModelType
    int type();

    @NonNull
    String id();

    @NonNull
    Status getStatus();
}
