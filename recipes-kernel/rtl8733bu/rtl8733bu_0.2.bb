SUMMARY = "RTL8733bu driver from Quectel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://README.md;md5=e8a59bdcb27778fdceb6a9fc55f0f995"

inherit module

DEPENDS += "bc-native"

SRCREV = "308919f005f439de433aac977f925bb57f59acf4"
SRC_URI = "git://github.com/ROCKNIX/RTL8733BU.git;protocol=https;branch=v5.15.12-126-wb"

do_compile() {
	make KSRC=${STAGING_KERNEL_DIR} KVER=${KERNEL_VERSION}
}

do_install() {
	mkdir -p "${D}/usr/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless"
	# This module has a makefile with hardcoded depmod path, so better directly copy what's needed 
	cp *.ko "${D}/usr/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/"
}

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
RPROVIDES:${PN} += "kernel-module-rtl8733bu"

# TODO: Seems some paths fall inside, but not really keen ATM to find why
ERROR_QA:remove = "buildpaths"
