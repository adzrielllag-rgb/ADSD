public class NodePesanan {
    pesanan01 data;
    NodePesanan prev;
    NodePesanan next;

    public NodePesanan(pesanan01 data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
