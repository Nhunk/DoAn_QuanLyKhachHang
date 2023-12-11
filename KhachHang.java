package DoAn_LeTranAnhNhung;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class KhachHang implements IKhachHang {

    String maKH, ten;
    boolean gioiTinh;
    Date ngayHoaDon;
    double donGia;
    int sl;

    public KhachHang() {
    }

    public KhachHang(String maKH, String ten, boolean gioiTinh, Date ngayHoaDon, double donGia, int sl) {
        this.maKH = maKH;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngayHoaDon = ngayHoaDon;
        this.donGia = donGia;
        this.sl = sl;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgayHoaDon() {
        return ngayHoaDon;
    }

    public void setNgayHoaDon(Date ngayHoaDon) {
        this.ngayHoaDon = ngayHoaDon;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public static boolean chuyenChuoiThanhGioiTinh(String str) {
        if (str.equalsIgnoreCase("Nam")) {
            return true;
        }
        return false;
    }

    public static String chuyenGioiTinhThanhChuoi(boolean gt) {
        if (gt) {
            return "Nam";
        }
        return "Nu";
    }

    public static Date chuyenChuoiThanhNgay(String str) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(str);
        } catch (Exception e) {
        }
        return null;
    }

    public static String chuyenNgayThanhChuoi(Date ngay) {
        return new SimpleDateFormat("dd/MM/yyyy").format(ngay);
    }
    public static String dinhDangSo(double n){
        DecimalFormat df=new DecimalFormat("###,###.0");
        return df.format(n);
    }
    @Override
    public String toString() {
        return maKH + "\t" + ten + "\t" + chuyenGioiTinhThanhChuoi(gioiTinh) + "\t" + chuyenNgayThanhChuoi(ngayHoaDon) + "\t" + donGia + "\t" + sl;
    }
}
