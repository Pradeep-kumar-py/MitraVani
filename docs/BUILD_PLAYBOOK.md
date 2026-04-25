# MitraVani Build Playbook

This is the working plan for turning the current Android starter project into a private, local-first AI companion app.

## Current State

- The project builds successfully with `./gradlew :app:assembleDebug`.
- `MainActivity` still shows the default Android greeting.
- Most planned feature files exist only as package placeholders.
- The repo is not currently a git repository.
- There is no real navigation, persistence, LLM runtime, voice pipeline, backup, or payment implementation yet.

## Product Promise

MitraVani should feel like a warm voice companion while keeping the privacy promise simple:

- Conversations stay on device by default.
- Long-term memory is stored locally.
- Cloud backup is optional and encrypted before upload.
- The app should be useful even when offline.
- We should never design a feature that requires the developer to read user conversations.

## Corrected AI Stack Direction

The startup note is directionally strong, but the implementation path should use the current Android AI stack:

- Prefer LiteRT-LM for direct model ownership, downloadable model files, benchmarking, and deeper runtime control.
- Use ML Kit GenAI Prompt API / AICore as a prototype path for supported devices when the app can accept API limits and device constraints.
- Avoid building new core architecture around MediaPipe LLM Inference. It still exists, but Google marks it deprecated and recommends migrating to LiteRT-LM.
- Use Gemma 4 E2B as the first serious local model target, then test E4B only on high-end devices.
- Treat Kokoro-82M as the long-term TTS target, but prove the conversation loop first. Voice quality should come after the local chat path is stable.

## Architecture Shape

Keep the app split by capability, not by hype:

- UI: Jetpack Compose screens and state holders.
- Domain: use cases, model interfaces, memory rules, safety policies.
- Data: Room database, local preferences, encrypted export/import.
- AI: local LLM adapter, prompt builder, memory extractor, summarizer.
- Voice: recorder, speech recognition, TTS playback, call state machine.
- Monetization: encrypted backup and model update features only after trust is earned.

## Milestones

### 0. Foundation

- Replace the template screen with a real MitraVani app shell.
- Add navigation between Chat, Voice, Memory, and Settings.
- Add dependencies only when a milestone needs them.
- Keep the app building after every step.

### 1. Thin Companion Slice

- Build a working chat UI.
- Add a local fake LLM engine with streaming-like responses.
- Persist messages locally.
- Add the first prompt/personality contract.
- Add tests around message persistence and prompt building.

Goal: the app feels like MitraVani before any heavy model work begins.

### 2. Real Local LLM

- Define a `CompanionLlm` interface so the app can switch between fake, ML Kit, and LiteRT-LM engines.
- Add model download/storage state.
- Integrate Gemma 4 E2B through the best available supported Android runtime.
- Benchmark time-to-first-token, tokens/sec, memory pressure, battery heat, and crash behavior.

Goal: text chat runs locally on a real phone.

### 3. Memory That Actually Helps

- Store the last messages as working memory.
- Generate compact session summaries.
- Extract durable facts only when confidence is high.
- Retrieve relevant memories before each response.
- Add a Memory screen where users can view, edit, and delete remembered facts.

Goal: the companion remembers without becoming creepy or uncontrollable.

### 4. Voice-First Experience

- Add microphone permission and recording.
- Choose STT path after testing device support: Gemma audio input, ML Kit speech recognition, or Whisper ONNX.
- Add TTS playback, starting simple if needed.
- Move toward Kokoro-82M ONNX after the call loop is stable.
- Build interruption, pause, resume, mute, and end-call behavior.

Goal: a real call-like loop, not a chatbot with audio pasted on top.

### 5. Privacy, Backup, And Trust

- Add local encryption primitives.
- Export the local memory database into an encrypted blob.
- Restore from encrypted backup.
- Add subscription only around backup/model convenience, not basic conversation.

Goal: the paid product strengthens trust instead of weakening it.

### 6. Safety And Polish

- Add emotional crisis handling and escalation copy.
- Add content boundaries for dependency, self-harm, harassment, and sexual content.
- Polish empty states, loading states, offline states, and model-missing states.
- Measure cold start, model load time, and battery impact.

Goal: extraordinary means reliable, respectful, and safe, not just impressive.

## First Code Slice

The best first implementation slice is:

1. Real Compose app shell.
2. Chat screen.
3. Fake streaming companion engine.
4. Local message state.
5. Prompt/personality contract.

This avoids getting trapped in model integration before the actual product experience exists.

