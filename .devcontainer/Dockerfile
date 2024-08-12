# using microsoft image as base dev container for best support vscode
FROM mcr.microsoft.com/devcontainers/java:17 AS vsc-java-dev
ENV XDG_CACHE_HOME="/workspace/local/tmp/java-17/.caches" \
    XDG_CONFIG_HOME="/workspace/local/tmp/java-17/config" \
    HISTFILE="/workspace/local/tmp/.zsh_history" \
    MAVEN_OPTS="-Dmaven.repo.local=/workspace/local/tmp/java-17/m2"
# RUN apt update \
#     && apt install -y libnss3 libnspr4 libdbus-1-3 libatk1.0-0 \
#       libatk-bridge2.0-0 libcups2 libatspi2.0-0 libxcomposite1 \
#       libxdamage1 libxfixes3 libxrandr2 libgbm1 libdrm2 libxkbcommon0 \
#       libasound2 \
#     && apt clean
