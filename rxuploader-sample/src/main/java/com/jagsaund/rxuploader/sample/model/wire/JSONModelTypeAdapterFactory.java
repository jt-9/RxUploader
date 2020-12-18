package com.jagsaund.rxuploader.sample.model.wire;

import androidx.annotation.NonNull;
import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

@GsonTypeAdapterFactory
public abstract class JSONModelTypeAdapterFactory implements TypeAdapterFactory {
    @NonNull
    public static TypeAdapterFactory create() {
        return new AutoValueGson_JSONModelTypeAdapterFactory();
    }
}
