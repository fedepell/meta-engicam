DESCRIPTION = "YASDI SMA library"
LICENSE = "LGPL-2.1-or-later"
HOMEPAGE = "https://www.sma.de/produkte/monitoring-control/yasdi.html"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7266a93b753b03bc5f00522e65722b79"
PR = "r6"

SRC_URI = "gitsm://github.com/fedepell/libyasdi.git;branch=gwcV4;protocol=https \
           file://0001-Fix_wrynose_build.patch"

SRCREV = "1603dde35668a115f84f9f94fadc8ff1054d9708"

inherit pkgconfig cmake

do_configure() {
   cmake -DCMAKE_INSTALL_PREFIX:PATH=/usr -DCMAKE_POLICY_VERSION_MINIMUM=3.5 ${S}/projects/generic-cmake
}


do_install:append() {
  mkdir -p ${D}/usr/include/yasdi
  install -m 644 ${S}/include/*.h ${D}/usr/include/yasdi
  install -m 644 ${S}/libs/*.h ${D}/usr/include/yasdi
  install -m 644 ${S}/smalib/*.h ${D}/usr/include/yasdi
  install -m 644 ${S}/smalib/*.h ${D}/usr/include/yasdi
  install -m 644 ${S}/core/*.h ${D}/usr/include/yasdi
  install -m 644 ${S}/projects/generic-cmake/incprj/*.h ${D}/usr/include/yasdi
  install -m 644 ${S}/os/*.h ${D}/usr/include/yasdi
  install -m 644 ${S}/protocol/*.h ${D}/usr/include/yasdi
}

FILES:${PN} += "${libdir}/libyasdi.so ${libdir}/libyasdi_drv_ip.so ${libdir}/libyasdi_drv_serial.so ${libdir}/libyasdimaster.so"
FILES:${PN}-dev = "${includedir}"

INSANE_SKIP:${PN} += "dev-so"
