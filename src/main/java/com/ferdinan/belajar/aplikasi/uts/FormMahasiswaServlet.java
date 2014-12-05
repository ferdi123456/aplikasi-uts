package com.ferdinan.belajar.aplikasi.uts;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormMahasiswaServlet extends HttpServlet {

    private MahasiswaDao mahasiswaDao = new MahasiswaDao();

    public void doGet(HttpServletRequest reg, HttpServletResponse res) {

    }

    public void doPost(HttpServletRequest reg, HttpServletResponse res) {
        try {
            Mahasiswa m = new Mahasiswa();
            m.setNpm(reg.getParameter("npm"));
            m.setNama(reg.getParameter("nama"));
            m.setTempatLahir(reg.getParameter("tempatLahir"));

            String strTanggalLahir = reg.getParameter("tanggalLahir");
            SimpleDateFormat formatterTanggal = new SimpleDateFormat("yyyy-MM-dd");
            m.setTanggalLahir(formatterTanggal.parse(strTanggalLahir));

            m.setJenisKelamin(JenisKelamin.valueOf(reg.getParameter("jenisKelamin").toUpperCase()));
            m.setAlamat(reg.getParameter("alamat"));

            mahasiswaDao.simpan(m);

            res.sendRedirect("form.html");
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

}
