package info.xiantang.messagequeue.kafka;

import java.io.Serializable;

public class TcpPackage implements Serializable {
    private int seq;
    private int flagACK;
    private int flagSYN;
    private int ack;


    public int getSeq() {
        return seq;
    }

    public TcpPackage(int ack) {
        this.ack = ack;
    }

    public TcpPackage(int seq, int flagACK, int SYN, int ack) {
        this.seq = seq;
        this.flagACK = flagACK;
        this.flagSYN = SYN;
        this.ack = ack;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getFlagACK() {
        return flagACK;
    }

    public void setFlagACK(int flagACK) {
        this.flagACK = flagACK;
    }

    public int getFlagSYN() {
        return flagSYN;
    }

    public void setFlagSYN(int flagSYN) {
        this.flagSYN = flagSYN;
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = obj instanceof TcpPackage;
        if (!b) {
            return false;
        }
        TcpPackage that = (TcpPackage) obj;
        return that.flagACK == this.flagACK && that.seq == this.seq && that.flagSYN == this.flagSYN;
    }

    public int getAck() {
        return ack;
    }
}
