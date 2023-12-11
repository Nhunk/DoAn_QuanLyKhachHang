package DoAn_LeTranAnhNhung;

import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLy_GUI extends javax.swing.JFrame {

    DanhSachKhachHang dskh;
    DefaultTableModel model;

    public QuanLy_GUI() {
        initComponents();
        myInit();
    }

    public void myInit() {
        setTitle("Quản lý khách hàng");
        setLocationRelativeTo(null);
        dskh = new DanhSachKhachHang();
        model = (DefaultTableModel) tbkh.getModel();
        tbkh.setModel(model);
        ButtonGroup group = new ButtonGroup();
        group.add(radioNam);
        group.add(radioNu);
        docFile();
        getContentPane().setBackground(new java.awt.Color(212,232,249));
        tbkh.setRowHeight(20);

    }

    public void xoaBang() {
        int n = tbkh.getRowCount();
        for (int i = n; i > 0; i--) {
            model.removeRow(i - 1);
        }
    }

    public void themMotDongVaoTable(KhachHang kh) {
        if (kh instanceof KhachNoiDia) {
            model.addRow(new Object[]{kh.getMaKH(), kh.getTen(), KhachHang.chuyenGioiTinhThanhChuoi(kh.isGioiTinh()), KhachHang.chuyenNgayThanhChuoi(kh.getNgayHoaDon()), kh.getDonGia(), kh.getSl(), ((KhachNoiDia) kh).getDoiTuong(), "",KhachHang.dinhDangSo(((KhachNoiDia) kh).thanhTien()), ((KhachNoiDia) kh).hangKH()});
        } else {
            KhachNgoaiQuoc knq = (KhachNgoaiQuoc) kh;
            model.addRow(new Object[]{kh.getMaKH(), kh.getTen(), KhachHang.chuyenGioiTinhThanhChuoi(kh.isGioiTinh()), KhachHang.chuyenNgayThanhChuoi(kh.getNgayHoaDon()), kh.getDonGia(), kh.getSl(), "", knq.getTiGia(), KhachHang.dinhDangSo(knq.thanhTien()), knq.hangKH()});
        }
    }

    public void docFile() {
        dskh.docFile("input.txt");
        inDS();
    }

    public void inDS() {
        xoaBang();
        for (KhachHang kh : dskh.arr) {
            themMotDongVaoTable(kh);
        }
    }

    public KhachNoiDia nhapKND() {
        String maKH = txtMa.getText();
        String ten = txtTen.getText();
        boolean gt = (radioNam.isSelected()) ? true : false;
        Date ngayHD = KhachHang.chuyenChuoiThanhNgay(txtNgayHD.getText());
        double donGia = Double.parseDouble(txtDonGia.getText());
        int sl = Integer.parseInt(txtSoLuong.getText());
        String doiTuong = txtDoiTuong.getText();
        KhachNoiDia knd = new KhachNoiDia(doiTuong, maKH, ten, gt, ngayHD, donGia, sl);
        return knd;
    }

    public KhachNgoaiQuoc nhapKNQ() {
        String maKH = txtMa.getText();
        String ten = txtTen.getText();
        boolean gt = (radioNam.isSelected()) ? true : false;
        Date ngayHD = KhachHang.chuyenChuoiThanhNgay(txtNgayHD.getText());
        double donGia = Double.parseDouble(txtDonGia.getText());
        int sl = Integer.parseInt(txtSoLuong.getText());
        float tiGia = Float.parseFloat(txtTiGia.getText());
        KhachNgoaiQuoc knq = new KhachNgoaiQuoc(tiGia, maKH, ten, gt, ngayHD, donGia, sl);
        return knq;
    }

    public boolean kiemTraMaKH(String maKH) {
        for (KhachHang kh : dskh.getDSKH()) {
            if (kh.getMaKH().equalsIgnoreCase(maKH)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbDoiTuong = new javax.swing.JLabel();
        lbTiGia = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox<>();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        radioNam = new javax.swing.JRadioButton();
        radioNu = new javax.swing.JRadioButton();
        txtNgayHD = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtDoiTuong = new javax.swing.JTextField();
        txtTiGia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbkh = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btCapNhat = new javax.swing.JButton();
        btSapXep = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btTimKiem = new javax.swing.JButton();
        btInDS = new javax.swing.JButton();
        btGhiFile = new javax.swing.JButton();
        btInDSHang = new javax.swing.JButton();
        btThemMoi = new javax.swing.JButton();
        btInDSLoai = new javax.swing.JButton();
        btInDSMax = new javax.swing.JButton();
        btInDSTheoTen = new javax.swing.JButton();
        btDoanhthu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        jPanel1.setBackground(new java.awt.Color(202, 226, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 255), 3, true), "Nhập thông tin", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Black", 0, 15), new java.awt.Color(0, 0, 153))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Mã KH");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Loại KH");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Tên");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Giới tính");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Ngày HD");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Đơn giá");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Số lượng");

        lbDoiTuong.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        lbDoiTuong.setForeground(new java.awt.Color(0, 0, 102));
        lbDoiTuong.setText("Đối tượng");

        lbTiGia.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        lbTiGia.setForeground(new java.awt.Color(0, 0, 102));
        lbTiGia.setText("Tỉ giá");

        ComboBox.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách Nội Địa", "Khách Ngoại Quốc" }));
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        txtMa.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        radioNam.setText("Nam");

        radioNu.setText("Nữ");

        txtNgayHD.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        txtDonGia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        txtDoiTuong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        txtTiGia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTen)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(lbDoiTuong)
                                    .addComponent(lbTiGia)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtDoiTuong, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNgayHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                            .addComponent(txtDonGia, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(12, 12, 12))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTiGia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(radioNam, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioNu, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(radioNu))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioNam)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDoiTuong)
                    .addComponent(txtDoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTiGia)
                    .addComponent(txtTiGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        tbkh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên", "Giới tính", "Ngày HĐ", "Đơn giá", "Số lượng", "Đối tượng", "Tỉ Giá", "Thành tiền", "Hạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbkh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbkhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbkh);

        jPanel2.setBackground(new java.awt.Color(202, 226, 247));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 255), 3, true), "Chọn chức năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Black", 0, 15), new java.awt.Color(0, 0, 153))); // NOI18N

        btCapNhat.setBackground(new java.awt.Color(0, 0, 153));
        btCapNhat.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btCapNhat.setText("Cập nhật");
        btCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhatActionPerformed(evt);
            }
        });

        btSapXep.setBackground(new java.awt.Color(0, 0, 153));
        btSapXep.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btSapXep.setForeground(new java.awt.Color(255, 255, 255));
        btSapXep.setText("Sắp xếp");
        btSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSapXepActionPerformed(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(0, 0, 153));
        btXoa.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btXoa.setForeground(new java.awt.Color(255, 255, 255));
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btTimKiem.setBackground(new java.awt.Color(0, 0, 153));
        btTimKiem.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btTimKiem.setText("Tìm kiếm");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        btInDS.setBackground(new java.awt.Color(0, 0, 153));
        btInDS.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btInDS.setForeground(new java.awt.Color(255, 255, 255));
        btInDS.setText("In danh sách");
        btInDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInDSActionPerformed(evt);
            }
        });

        btGhiFile.setBackground(new java.awt.Color(0, 0, 153));
        btGhiFile.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btGhiFile.setForeground(new java.awt.Color(255, 255, 255));
        btGhiFile.setText("Ghi File");
        btGhiFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGhiFileActionPerformed(evt);
            }
        });

        btInDSHang.setBackground(new java.awt.Color(0, 0, 153));
        btInDSHang.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btInDSHang.setForeground(new java.awt.Color(255, 255, 255));
        btInDSHang.setText("DS theo hạng KH");
        btInDSHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInDSHangActionPerformed(evt);
            }
        });

        btThemMoi.setBackground(new java.awt.Color(0, 0, 153));
        btThemMoi.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btThemMoi.setForeground(new java.awt.Color(255, 255, 255));
        btThemMoi.setText("Thêm mới");
        btThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemMoiActionPerformed(evt);
            }
        });

        btInDSLoai.setBackground(new java.awt.Color(0, 0, 153));
        btInDSLoai.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btInDSLoai.setForeground(new java.awt.Color(255, 255, 255));
        btInDSLoai.setText("DS theo loại KH");
        btInDSLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInDSLoaiActionPerformed(evt);
            }
        });

        btInDSMax.setBackground(new java.awt.Color(0, 0, 153));
        btInDSMax.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btInDSMax.setForeground(new java.awt.Color(255, 255, 255));
        btInDSMax.setText("DS hóa đơn lớn nhất");
        btInDSMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInDSMaxActionPerformed(evt);
            }
        });

        btInDSTheoTen.setBackground(new java.awt.Color(0, 0, 153));
        btInDSTheoTen.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btInDSTheoTen.setForeground(new java.awt.Color(255, 255, 255));
        btInDSTheoTen.setText("DS theo tên gần đúng");
        btInDSTheoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInDSTheoTenActionPerformed(evt);
            }
        });

        btDoanhthu.setBackground(new java.awt.Color(0, 0, 153));
        btDoanhthu.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btDoanhthu.setForeground(new java.awt.Color(255, 255, 255));
        btDoanhthu.setText("Doanh thu");
        btDoanhthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoanhthuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btInDS)
                    .addComponent(btThemMoi)
                    .addComponent(btInDSMax))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btXoa)
                    .addComponent(btInDSLoai)
                    .addComponent(btDoanhthu))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSapXep)
                    .addComponent(btInDSTheoTen)
                    .addComponent(btGhiFile))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btInDSHang)
                    .addComponent(btCapNhat)
                    .addComponent(btTimKiem))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThemMoi)
                    .addComponent(btXoa)
                    .addComponent(btSapXep)
                    .addComponent(btTimKiem))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btInDS)
                            .addComponent(btCapNhat))
                        .addComponent(btDoanhthu, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btGhiFile))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInDSMax)
                    .addComponent(btInDSLoai)
                    .addComponent(btInDSTheoTen)
                    .addComponent(btInDSHang))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        if (ComboBox.getSelectedIndex() == 0) {
            txtDoiTuong.setVisible(true);
            txtTiGia.setVisible(false);
            lbDoiTuong.setVisible(true);
            lbTiGia.setVisible(false);

        } else {
            txtDoiTuong.setVisible(false);
            txtTiGia.setVisible(true);
            lbDoiTuong.setVisible(false);
            lbTiGia.setVisible(true);
        }
    }//GEN-LAST:event_ComboBoxActionPerformed

    private void btThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemMoiActionPerformed
        String maKH = txtMa.getText();
        if (kiemTraMaKH(maKH) || maKH.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã KH bị trùng/ trống!");
        } else {
            if (ComboBox.getSelectedIndex() == 0) {
                KhachNoiDia knd = nhapKND();
                dskh.themVaoDS(knd);
                themMotDongVaoTable(knd);
            } else {
                KhachNgoaiQuoc knq = nhapKNQ();
                dskh.themVaoDS(knq);
                themMotDongVaoTable(knq);
            }
        }
    }//GEN-LAST:event_btThemMoiActionPerformed

    private void btInDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInDSActionPerformed
        inDS();
    }//GEN-LAST:event_btInDSActionPerformed

    private void btInDSHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInDSHangActionPerformed
        String hangKH = JOptionPane.showInputDialog("Nhập hạng cần in ds:\n(0/Bạc/ Vàng/ Kim Cương)");
        xoaBang();
        for (KhachHang kh : dskh.getDSTheoHang(hangKH)) {
            themMotDongVaoTable(kh);
        }
    }//GEN-LAST:event_btInDSHangActionPerformed

    private void btGhiFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGhiFileActionPerformed
        String tenFile = JOptionPane.showInputDialog("Nhập tên file");
        dskh.ghiFile(tenFile);// thi nên set cứng tên file
        JOptionPane.showMessageDialog(null, "Ghi File thành công");
    }//GEN-LAST:event_btGhiFileActionPerformed

    private void btCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhatActionPerformed
        KhachHang kh = dskh.timKiem(txtMa.getText());
        if (kh == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhâp mã KH để cập nhật!");
        } else {

            kh.setMaKH(txtMa.getText());
            kh.setTen(txtTen.getText());
            kh.setGioiTinh(radioNam.isSelected());
            kh.setNgayHoaDon(KhachHang.chuyenChuoiThanhNgay(txtNgayHD.getText()));
            kh.setDonGia(Double.parseDouble(txtDonGia.getText()));
            kh.setSl(Integer.parseInt(txtSoLuong.getText()));
            if (kh instanceof KhachNoiDia) {
                ((KhachNoiDia) kh).setDoiTuong(txtDoiTuong.getText());
            } else {
                KhachNgoaiQuoc knq = (KhachNgoaiQuoc) kh;
                knq.setTiGia(Float.parseFloat(txtTiGia.getText()));
            }
            xoaBang();
            themMotDongVaoTable(kh);
        }
    }//GEN-LAST:event_btCapNhatActionPerformed

    private void btSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSapXepActionPerformed
        dskh.sapXep();
        inDS();
    }//GEN-LAST:event_btSapXepActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        String maKH = txtMa.getText();
        if (dskh.xoaTheoMaKH(maKH)) {
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            inDS();
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy mã!");
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
        String maKH = JOptionPane.showInputDialog("Nhập mã khách hàng cần tìm");
        KhachHang kh = dskh.timKiem(maKH);
        if (kh != null) {
            xoaBang();
            themMotDongVaoTable(kh);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy!");
        }
    }//GEN-LAST:event_btTimKiemActionPerformed

    private void tbkhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbkhMouseClicked
        int i = tbkh.getSelectedRow();
        if (evt.getClickCount() == 2) {
            String doiTuong = model.getValueAt(i, 6).toString();
            if (doiTuong == "") {
                ComboBox.setSelectedItem("Khách Ngoại Quốc");
            } else {
                ComboBox.setSelectedItem("Khách Nội Địa");
                
            }
            txtMa.setText(model.getValueAt(i, 0).toString());
            txtTen.setText(model.getValueAt(i, 1).toString());
            if (model.getValueAt(i, 2).toString().equalsIgnoreCase("Nam")) {
                radioNam.setSelected(true);
            } else {
                radioNu.setSelected(true);
            }
            txtNgayHD.setText(model.getValueAt(i, 3).toString());
            txtDonGia.setText(model.getValueAt(i, 4).toString());
            txtSoLuong.setText(model.getValueAt(i, 5).toString());            
            txtDoiTuong.setText(doiTuong);
            txtTiGia.setText(model.getValueAt(i, 7).toString());
        }
    }//GEN-LAST:event_tbkhMouseClicked

    private void btInDSLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInDSLoaiActionPerformed
        String loaiKH = JOptionPane.showInputDialog("Nhập loại khách hàng: \n(knd / knq)");
        xoaBang();
        for (KhachHang kh : dskh.getDSTheoLoai(loaiKH)) {
            themMotDongVaoTable(kh);
        }
    }//GEN-LAST:event_btInDSLoaiActionPerformed

    private void btInDSMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInDSMaxActionPerformed
        xoaBang();
        for (KhachHang kh : dskh.getDSMax()) {
            themMotDongVaoTable(kh);
        }
    }//GEN-LAST:event_btInDSMaxActionPerformed

    private void btInDSTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInDSTheoTenActionPerformed
        String ten=JOptionPane.showInputDialog("Nhập tên gần đúng");
        xoaBang();
        for (KhachHang kh : dskh.getDSTheoTenGanDung(ten)) {
            themMotDongVaoTable(kh);
        }
    }//GEN-LAST:event_btInDSTheoTenActionPerformed

    private void btDoanhthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoanhthuActionPerformed
        double t=dskh.tinhTong();
        JOptionPane.showMessageDialog(null, "Tổng doanh thu là: "+t);
    }//GEN-LAST:event_btDoanhthuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLy_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLy_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLy_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLy_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLy_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JButton btCapNhat;
    private javax.swing.JButton btDoanhthu;
    private javax.swing.JButton btGhiFile;
    private javax.swing.JButton btInDS;
    private javax.swing.JButton btInDSHang;
    private javax.swing.JButton btInDSLoai;
    private javax.swing.JButton btInDSMax;
    private javax.swing.JButton btInDSTheoTen;
    private javax.swing.JButton btSapXep;
    private javax.swing.JButton btThemMoi;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDoiTuong;
    private javax.swing.JLabel lbTiGia;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioNu;
    private javax.swing.JTable tbkh;
    private javax.swing.JTextField txtDoiTuong;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgayHD;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTiGia;
    // End of variables declaration//GEN-END:variables
}
