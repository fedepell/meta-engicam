DESCRIPTION = "YASDI SMA library"
LICENSE = "LGPL-2.1"
HOMEPAGE = "https://www.sma.de/produkte/monitoring-control/yasdi.html"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7266a93b753b03bc5f00522e65722b79"
PR = "r1"

SRC_URI = "gitsm://github.com/fedepell/libyasdi.git;branch=gwcV4"

SRCREV = "33c49b092f0da597bb42057f98f9c3a27526679f"

inherit pkgconfig cmake

S = "${WORKDIR}/git"


do_configure() {
   cmake -DCMAKE_INSTALL_PREFIX:PATH=/usr ${WORKDIR}/git/projects/generic-cmake
}


do_install_append() {
  mkdir -p ${D}/usr/include/yasdi
  install -m 644 ${WORKDIR}/git/include/*.h ${D}/usr/include/yasdi
  install -m 644 ${WORKDIR}/git/libs/*.h ${D}/usr/include/yasdi
  install -m 644 ${WORKDIR}/git/smalib/*.h ${D}/usr/include/yasdi
  install -m 644 ${WORKDIR}/git/smalib/*.h ${D}/usr/include/yasdi
  install -m 644 ${WORKDIR}/git/core/*.h ${D}/usr/include/yasdi
  install -m 644 ${WORKDIR}/git/projects/generic-cmake/incprj/*.h ${D}/usr/include/yasdi
  install -m 644 ${WORKDIR}/git/os/*.h ${D}/usr/include/yasdi
  install -m 644 ${WORKDIR}/git/protocol/*.h ${D}/usr/include/yasdi
}

FILES_${PN} += "${libdir}/libyasdi.so ${libdir}/libyasdi_drv_ip.so ${libdir}/libyasdi_drv_serial.so ${libdir}/libyasdimaster.so"
FILES_${PN}-dev = "${includedir}"

INSANE_SKIP_${PN} += "dev-so"
