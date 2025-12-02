package com.example.demotest.config;

import io.opentelemetry.api.OpenTelemetry;
import org.springframework.beans.factory.InitializingBean;
import io.opentelemetry.instrumentation.logback.appender.v1_0.OpenTelemetryAppender;

class InstallOpenTelemetryAppender implements InitializingBean {

    private final OpenTelemetry openTelemetry;

    InstallOpenTelemetryAppender(OpenTelemetry openTelemetry) {
        this.openTelemetry = openTelemetry;
    }

    @Override
    public void afterPropertiesSet() {
        OpenTelemetryAppender.install(this.openTelemetry);
    }

}
