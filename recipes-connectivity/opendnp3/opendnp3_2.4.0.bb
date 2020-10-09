DESCRIPTION = "OpenDNP3 library"
DEPENDS="boost asio"
LICENSE="Apache-2.0"
HOMEPAGE = "https://dnp3.github.io/"
LIC_FILES_CHKSUM = "file://config/APACHE_LICENSE_HEADER;md5=dfce487768755d05f223fff2198626f3"

SRC_URI = "https://github.com/dnp3/opendnp3/archive/2.4.0.tar.gz"
SRC_URI[sha256sum] = "3d6d00d42841f464ecab736aba3ae82391b62f050db4efeba50cae9778d54421"

inherit cmake

S="${WORKDIR}/opendnp3-${PV}"

