# Configuração de status HTTP

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarEventoPorId(@PathVariable Long id){
        Optional<Evento> evento = eventoService.buscarEventoPorId(id);

        if (evento.isPresent()) {
            return ResponseEntity.ok(evento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(@PathVariable long id, @RequestBody Evento evento){
        Optional<Evento> existente = eventoService.buscarEventoPorId(id);

        if (existente.isPresent()) {
            Evento atualizado = eventoService.atualizarEvento(id, evento);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEvento(@PathVariable Long id){
        Optional<Evento> existente = eventoService.buscarEventoPorId(id);

        if (existente.isPresent()) {
            eventoService.deletarEvento(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> criarEvento(@RequestBody Evento evento){
        if (evento.getNome() == null || evento.getNome().isEmpty()) {
            return ResponseEntity.badRequest().body("Nome do evento é obrigatório");
        }

        Evento request = eventoService.criarEvento(evento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
}
