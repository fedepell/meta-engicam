SUMMARY = "RTL8733bu driver from Quectel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README.md;md5=06e9d5a41e8acec1af7a06452d67ee6d"

inherit module

S = "${WORKDIR}/git"


DEPENDS += "bc-native"

SRCREV = "3a0a44e9ab51da327cadb783ac6f2cc95f643c35"
SRC_URI = "git://github.com/fedepell/rtl8733bu.git;branch=master"

do_compile() {
	export CFLAGS="$CFLAGS -DDEBUG"
	make KSRC=${STAGING_KERNEL_DIR}
}

do_install() {
	mkdir -p "${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless"
	make install KSRC=${STAGING_KERNEL_DIR} INSTALL_MOD_PATH="${D}" MODDESTDIR="${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/"
}


# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
RPROVIDES_${PN} += "kernel-module-rtl8733bu"
