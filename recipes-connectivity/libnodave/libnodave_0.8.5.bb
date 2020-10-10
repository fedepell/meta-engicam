DESCRIPTION = "LIBNODAVE -- Exchange data with Siemens PLCs"
LICENSE = "GPLv2"
HOMEPAGE = "http://libnodave.sourceforge.net/"
LIC_FILES_CHKSUM = "file://doc/index.html;md5=f83c2c7b30f118247e40f5e73a56ee1a"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/libnodave/libnodave/libnodave-${PV}.tar.gz \
           file://0001-Remove_make_env_overrides.patch"
SRC_URI[sha256sum] = "983d09771c07d53f409ec8d63a936906a1d4383cf6d590954fdf754f5c76761f"

inherit autotools

S = "${WORKDIR}/libnodave-${PV}"

CFLAGS_append += " -DLINUX -DDAVE_LITTLE_ENDIAN"
CPPFLAGS_append += " -DLINUX -DDAVE_LITTLE_ENDIAN"

do_compile() {
   cd ${S}
   oe_runmake
}


do_install() {
   cd ${S}
   export PREFIX=${D}
   mkdir -p ${D}/usr/lib ${D}/usr/include
   oe_runmake install
}

FILES_${PN}-dev = "/usr/include/nodave.h"
FILES_${PN} = "${libdir}/libnodave.so"
