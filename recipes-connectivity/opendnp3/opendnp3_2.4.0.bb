DESCRIPTION = "OpenDNP3 library"
DEPENDS = "boost asio"
LICENSE = "Apache-2.0"
HOMEPAGE = "https://dnp3.github.io/"
LIC_FILES_CHKSUM = "file://config/APACHE_LICENSE_HEADER;md5=dfce487768755d05f223fff2198626f3"

SRC_URI = "git://github.com/dnp3/opendnp3.git;branch=2.4.0;protocol=https"
SRC_URI[sha256sum] = "3d6d00d42841f464ecab736aba3ae82391b62f050db4efeba50cae9778d54421"

# There is something very wrong with the repo as the commit that is referenced from the
# tag doesn't seem to be in main tree :?
SRCREV = "843e5c79bfcbbf2a1486adbdb1d5692e298bda08"

inherit cmake

S = "${WORKDIR}/opendnp3-${PV}"

