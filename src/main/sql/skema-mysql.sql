create table mahasiswa(
	id int primary key auto_increment,
	npm varchar(255) not null,
	nama varchar(255) not null,
	tempat_lahir varchar(255) not null,
	tanggal_lahir date not null,
	jenis_kelamin varchar(255) not null,
	alamat varchar(255) not null
	)engine=innoDB;
