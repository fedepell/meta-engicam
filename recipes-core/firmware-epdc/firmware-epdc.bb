DESCRIPTION = "Firmware files for epd display"
S = "${UNPACKDIR}"

LICENSE = "CLOSED"

SRC_URI = "file://epdc"

do_install() {
	install -d ${D}/lib/firmware/imx
	install -d ${D}/lib/firmware/imx/epdc
	install -m 0755 ${S}/epdc/* ${D}/lib/firmware/imx/epdc
}

FILES:${PN} =  "/lib/firmware/imx/*"
