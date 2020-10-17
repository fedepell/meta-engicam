DESCRIPTION = "fswebcam - Small and simple webcam software for *nix"
LICENSE = "GPLv2"
HOMEPAGE = "https://github.com/fsphil/fswebcam"
LIC_FILES_CHKSUM = "file://LICENSE;md5=393a5ca445f6965873eca0259a17f833"

DEPENDS += "gd"
RDEPENDS_${PN} += "gd"

SRC_URI = "git://github.com/fsphil/fswebcam.git;branch=master"

SRCREV = "db35d4bbd336885a44f017ff142bc9523dbdce3c"
S = "${WORKDIR}/git"

inherit autotools pkgconfig


EXTRA_OEMAKE = "DESTDIR=${D}"

do_configure() {
    cd ${S}
    oe_runconf
}

do_compile() {
    cd ${S}
    oe_runmake
}

do_install() {
    cd ${S}
    oe_runmake install
}
