DESCRIPTION = "YASDI SMA library"
LICENSE = "LGPL"
HOMEPAGE = "https://www.sma.de/produkte/monitoring-control/yasdi.html"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7266a93b753b03bc5f00522e65722b79"

SRC_URI = "gitsm://github.com/pknowledge/libyasdi.git;branch=master"

SRCREV = "fc531895019b7b2b595f9cda3bdf6cd72c0e211e"

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
}
