package com.algaworks.algasensors.device.management.common;

import io.hypersistence.tsid.TSID;
import java.util.Optional;

public class IdGenerator {

    private static final TSID.Factory tsidFactory;

    static {
        Optional.ofNullable(System.getenv("tsid.node"))
                .ifPresent(tsidFactory -> System.setProperty("tsid.node", tsidFactory));

        Optional.ofNullable(System.getenv("tsid.node.count"))
                .ifPresent(tsidNodeCount -> System.setProperty("tsid.node.count", tsidNodeCount));

        tsidFactory = TSID.Factory.builder().build();
    }

    private IdGenerator() {

    }

    public static TSID generateTSID() {
        return tsidFactory.generate();
    }

}
