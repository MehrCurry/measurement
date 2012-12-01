package de.gzockoll.observation;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.joda.time.DateTime;

public abstract class Observation {
    protected final DateTime timeTaken = new DateTime();
    protected Subject subject;

    public Observation(Subject subject) {
        super();
        this.subject = subject;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public abstract Object getValue();
}
