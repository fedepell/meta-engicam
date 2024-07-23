SUMMARY = "RTL8733bu driver from Quectel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README.md;md5=3bb007783e0d51c86195b4cae631dc99"

inherit module

S = "${WORKDIR}/git"

DEPENDS += "bc-native"

SRCREV = "bdcbe1798b9cf93721a17454a39349f19b4d5c83"
SRC_URI = "git://github.com/fedepell/rtl8733bu.git;branch=master file://0001-Disable_dual_mode.patch"

do_compile() {
	make KSRC=${STAGING_KERNEL_DIR} KVER=${KERNEL_VERSION}
}

do_install() {
	mkdir -p "${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless"
	# This module has a makefile with hardcoded depmod path, so better directly copy what's needed 
	cp *.ko "${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/"
}

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
RPROVIDES_${PN} += "kernel-module-rtl8733bu"
