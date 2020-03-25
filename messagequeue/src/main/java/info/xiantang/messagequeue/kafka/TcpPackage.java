package info.xiantang.messagequeue.kafka;

import java.io.Serializable;

public class TcpPackage implements Serializable {
    private int seq;
    private int flagACK;
    private int flagSYN;
    private int ack;
    private byte[] data;


    public int getSeq() {
        return seq;
    }

    public TcpPackage(int ack) {
        this.ack = ack;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public TcpPackage(int seq, int flagACK, int flagSYN, int ack, byte[] data) {

        this.seq = seq;
        this.flagACK = flagACK;
        this.flagSYN = flagSYN;
        this.ack = ack;
        this.data = data;
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
