SUMMARY = "Basic script for mtd programming"
DESCRIPTION = "This package provides basic script for mtd programming"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/copyright;md5=608bed987af1b677f1378e29e4878154"

inherit allarch

RDEPENDS:${PN} += "u-boot-fw-utils"

SRC_URI = "file://prboot.sh \
           file://prfs.sh \
           file://prkernel.sh \
	   file://prdtb.sh \
           file://tftp_boot.sh \
           file://tftp_kernel.sh \
	   file://tftp_dtb.sh \
           file://tftp_fs.sh \
           file://fw_savenv.sh \
	   file://copyright"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${UNPACKDIR}/prboot.sh ${D}${bindir}/prboot.sh
	install -m 0755 ${UNPACKDIR}/prfs.sh ${D}${bindir}/prfs.sh
	install -m 0755 ${UNPACKDIR}/prkernel.sh ${D}${bindir}/prkernel.sh
	install -m 0755 ${UNPACKDIR}/prdtb.sh ${D}${bindir}/prdtb.sh
	install -m 0755 ${UNPACKDIR}/tftp_boot.sh ${D}${bindir}/tftp_boot.sh
	install -m 0755 ${UNPACKDIR}/tftp_kernel.sh ${D}${bindir}/tftp_kernel.sh
	install -m 0755 ${UNPACKDIR}/tftp_dtb.sh ${D}${bindir}/tftp_dtb.sh
	install -m 0755 ${UNPACKDIR}/tftp_fs.sh ${D}${bindir}/tftp_fs.sh
	install -m 0755 ${UNPACKDIR}/fw_savenv.sh ${D}${bindir}/fw_savenv.sh
}
