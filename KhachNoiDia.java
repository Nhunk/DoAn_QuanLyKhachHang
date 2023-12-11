
package DoAn_LeTranAnhNhung;

import java.util.Date;


public class KhachNoiDia extends KhachHang{
    String doiTuong;

    public KhachNoiDia() {
    }

    public KhachNoiDia(String doiTuong, String maKH, String ten, boolean gioiTinh, Date ngayHoaDon, double donGia, int sl) {
        super(maKH, ten, gioiTinh, ngayHoaDon, donGia, sl);
        this.doiTuong = doiTuong;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }
    
    @Override
    public double thanhTien() {
        if(doiTuong.equalsIgnoreCase("Khach si")){
            return donGia*sl*0.8;
        }
        return donGia*sl;
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
        return super.toString()+"\t"+doiTuong+"\t"+dinhDangSo(thanhTien())+"\t"+hangKH(); 
    }  
    
}
