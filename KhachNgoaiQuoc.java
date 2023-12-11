
package DoAn_LeTranAnhNhung;

import java.util.Date;


public class KhachNgoaiQuoc extends KhachHang{
    float tiGia;

    public KhachNgoaiQuoc() {
    }

    public KhachNgoaiQuoc(float tiGia, String maKH, String ten, boolean gioiTinh, Date ngayHoaDon, double donGia, int sl) {
        super(maKH, ten, gioiTinh, ngayHoaDon, donGia, sl);
        this.tiGia = tiGia;
    }

    public float getTiGia() {
        return tiGia;
    }

    public void setTiGia(float tiGia) {
        this.tiGia = tiGia;
    }
    
    @Override
    public double thanhTien() {
        return donGia*sl*tiGia;
    }

    @Override
    public String hangKH() {
        if(thanhTien()>=200000){
            return "Kim Cương";
        }
        if(thanhTien()>=100000){
            return "Vàng";
        }
        if(thanhTien()>=50000){
                return "Bạc";
        }
        return "0";
    }

    @Override
    public String toString() {
        return super.toString()+"\t"+tiGia+"\t"+dinhDangSo(thanhTien())+"\t"+hangKH();
    }    
    
}
