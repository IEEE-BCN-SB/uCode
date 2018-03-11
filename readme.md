## Presentacion
`https://docs.google.com/presentation/d/1-BCeal05KQ9Jy7fsLAOdLrWWHXRo1JFt3rG3fmLXaKU/edit?usp=sharing`


## Docker

### Install docker
```bash
sudo apt-get remove docker docker-engine docker.io
sudo apt-get update
sudo apt-get install apt-transport-https ca-certificates curl software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
sudo apt-get update
sudo apt-get install docker-ce
```

### Docker a non-root
```bash
sudo groupadd docker
sudo usermod -aG docker $USER
#docker run hello-world
```

### Install docker composer
```bash
sudo curl -L https://github.com/docker/compose/releases/download/1.19.0/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
sudo curl -L https://raw.githubusercontent.com/docker/compose/1.19.0/contrib/completion/bash/docker-compose -o /etc/bash_completion.d/docker-compose
source ~/.bashrc
# docker-compose --version
```