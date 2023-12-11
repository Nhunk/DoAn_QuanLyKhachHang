
package DoAn_LeTranAnhNhung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

public class DanhSachKhachHang {
    ArrayList<KhachHang> arr=new ArrayList<>();
    public void themVaoDS(KhachHang kh){
        arr.add(kh);
    }
    public void docFile(String tenFile){
        try {
            FileReader fr=new FileReader(tenFile);
            BufferedReader br=new BufferedReader(fr);
            String line = "";
            while (true) {                
                line =br.readLine();
                if(line==null){
                    break;
                }
                String s[]=line.split(",");
                String maKH=s[1];
                String ten=s[2];
                boolean gioiTinh=KhachHang.chuyenChuoiThanhGioiTinh(s[3]);
                Date ngayHoaDon=KhachHang.chuyenChuoiThanhNgay(s[4]);
                double donGia=Double.parseDouble(s[5]);
                int sl=Integer.parseInt(s[6]);
                if(s[0].equalsIgnoreCase("1")){
                    String doiTuong=s[7];
                    KhachNoiDia knd=new KhachNoiDia(doiTuong, maKH, ten, gioiTinh, ngayHoaDon, donGia, sl);
                    themVaoDS(knd);
                }else{
                    float tiGia=Float.parseFloat(s[7]);
                    KhachNgoaiQuoc knn=new KhachNgoaiQuoc(tiGia, maKH, ten, gioiTinh, ngayHoaDon, donGia, sl);
                    themVaoDS(knn);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }
    }
    public void ghiFile(String tenFile) {
        try {
            FileWriter fw = new FileWriter(tenFile);
            BufferedWriter bw = new BufferedWriter(fw);
            for (KhachHang kh : arr) {           
                bw.write(kh.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
    public boolean xoaTheoMaKH(String maKH){
        for (KhachHang kh : arr) {
            if(maKH.equalsIgnoreCase(maKH.trim())){
                arr.remove(kh);
                return true;
            }
        }
        return false;
    }
    public void sapXep() {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j).thanhTien() > arr.get(i).thanhTien()) {
                    KhachHang temp = arr.set(i, arr.get(i));
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }

        }
    }
    public KhachHang timKiem(String maKH){
        for (KhachHang kh : arr) {
            if(kh.getMaKH().equalsIgnoreCase(maKH)){
                return kh;
            }
        }
        return null;
    }
    public ArrayList<KhachHang> getDSKH(){
        return arr;
    }
    public ArrayList<KhachHang> getDSTheoHang(String hangKH){
        ArrayList<KhachHang> b=new ArrayList<>();
        for (KhachHang kh : arr) {
            if(kh.hangKH().equalsIgnoreCase(hangKH)){
                b.add(kh);
            }
        }
        return b;
    }
    
    public double timMax(){
        double max=0;
        for (KhachHang kh : arr) {
            if(kh instanceof KhachNoiDia){
                if(kh.thanhTien()>max){
                    max=kh.thanhTien();
                }
            }
        }
        return max;
    }
    public ArrayList<KhachHang> getDSMax(){
        ArrayList<KhachHang> b=new ArrayList<>();
        for (KhachHang kh : arr) {
            if(kh instanceof KhachNoiDia){
                if(kh.thanhTien()==timMax()){
                    b.add(kh);
                }
            }
        }
        return b;
    }
    public ArrayList<KhachHang> getDSTheoLoai(String loaiKH){
        ArrayList<KhachHang> b=new ArrayList<>();
        if(loaiKH.equalsIgnoreCase("knd")){
            for (KhachHang kh : arr) {
                if(kh instanceof KhachNoiDia){
                    b.add(kh);
                }
            }
        }
        if(loaiKH.equalsIgnoreCase("knq")){
            for (KhachHang kh : arr) {
                if(kh instanceof KhachNgoaiQuoc){
                    b.add(kh);
                }
            }
        }
        return b;
    }
    public ArrayList<KhachHang> getDSTheoTenGanDung(String ten){
        ArrayList<KhachHang> b=new ArrayList<>();
        for (KhachHang kh : arr) {
            if(kh.getTen().toLowerCase().contains(ten.toLowerCase())){
                b.add(kh);
            }
        }
        return b;
    }
    public double tinhTong(){
        double s1=0, s2=0;
        for (KhachHang kh : arr) {
            if(kh instanceof KhachNoiDia knd){
                s1+=knd.thanhTien();
            }else{
                KhachNgoaiQuoc knq=(KhachNgoaiQuoc) kh;
                s2+=knq.thanhTien();
            }            
        }
        return s1+s2;
    }
}
