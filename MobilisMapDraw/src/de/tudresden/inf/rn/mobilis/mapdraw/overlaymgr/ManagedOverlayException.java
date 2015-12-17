package de.tudresden.inf.rn.mobilis.mapdraw.overlaymgr;

public class ManagedOverlayException extends Exception{

    public ManagedOverlayException() {
    }

    public ManagedOverlayException(String s) {
        super(s);
    }

    public ManagedOverlayException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ManagedOverlayException(Throwable throwable) {
        super(throwable);
    }
}
